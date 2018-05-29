/*
 *     Copyright 2015-2018 discord-java
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package club.minnced.opus.util;

import com.sun.jna.Platform;

import java.io.IOException;
import java.util.*;

/**
 * Interface for opus binaries
 */
public final class OpusLibrary {
    private static boolean initialized = false;
    private static final String SUPPORTED_SYSTEMS;
    private static final Map<String, String> platforms;

    static {
        platforms = new HashMap<>(10);
        platforms.put("darwin", "dylib");
        platforms.put("linux-arm", "so");
        platforms.put("linux-aarch64", "so");
        platforms.put("linux-x86", "so");
        platforms.put("linux-x86-64", "so");
        platforms.put("win32-x86", "dll");
        platforms.put("win32-x86-64", "dll");
        SUPPORTED_SYSTEMS = "Supported Systems: " + platforms.values() + "\nCurrent Operating system: " + Platform.RESOURCE_PREFIX;
    }

    private OpusLibrary() {}

    /**
     * The currently supported platforms
     * <br>These are using the format described by JNA
     *
     * @return Immutable list of currently supported platforms
     */
    public static List<String> getSupportedPlatforms() {
        return Collections.unmodifiableList(new ArrayList<>(platforms.values()));
    }

    /**
     * Whether the current platform is supported
     *
     * @return True, if the current platform is supported
     */
    public static boolean isSupportedPlatform() {
        return platforms.containsKey(Platform.RESOURCE_PREFIX);
    }

    /**
     * Whether the library was successfully initialized already
     * <br>This is set to true when a library was loaded without an exception.
     *
     * @return True, if the library was already initialized
     */
    public static synchronized boolean isInitialized() {
        return initialized;
    }

    /**
     * Loads the library of the provided absolute path
     *
     * @param  absolutePath
     *         The path to load from
     *
     * @return True, if the library was loaded successfully.
     *         <br>False, if the library was already loaded before.
     */
    public static synchronized boolean loadFrom(String absolutePath) {
        if (initialized)
            return false;
        System.load(absolutePath);
        System.setProperty("opus.lib", absolutePath);
        return initialized = true;
    }

    /**
     * Loads the library from the current classpath
     *
     * @throws IOException
     *         If an I/O error occurred
     * @throws UnsupportedOperationException
     *         If the current platform is not supported
     *
     * @return True, if the library was loaded successfully.
     *         <br>False, if the library was already loaded before.
     */
    public static synchronized boolean loadFromJar() throws IOException {
        if (initialized)
            return false;
        String nativesRoot = "";
        try {
            //The libraries that this is referencing are available in the src/main/resources/natives/ folder.
            //Of course, when the jar is compiled that just becomes /natives/
            String platform = Platform.RESOURCE_PREFIX;
            String ext = platforms.get(platform);
            if (ext == null)
                throw new UnsupportedOperationException(SUPPORTED_SYSTEMS);

            String tmpRoot = String.format("/natives/%s/libopus.%s", platform, ext);
            NativeUtil.loadLibraryFromJar(tmpRoot);
            nativesRoot = tmpRoot;
            initialized = true;
        } finally {
            System.setProperty("opus.lib", nativesRoot);
        }
        return true;
    }
}
