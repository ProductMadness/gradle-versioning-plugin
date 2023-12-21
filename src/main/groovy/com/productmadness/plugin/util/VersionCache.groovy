package com.productmadness.plugin.util

class VersionCache {

    private static boolean initialized = false
    private static Integer major
    private static Integer minor
    private static Integer patch

    static void initialize(Integer major, Integer minor, Integer patch) {
        this.major = major
        this.minor = minor
        this.patch = patch
        initialized = true
    }

    static boolean isInitialized() {
        return initialized
    }

    static Integer getMajor() {
        return major
    }

    static Integer getMinor() {
        return minor
    }

    static Integer getPatch() {
        return patch
    }

    static void reset() {
        major = null
        minor = null
        patch = null
        initialized = false
    }

}
