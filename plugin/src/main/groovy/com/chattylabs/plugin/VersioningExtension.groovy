package com.chattylabs.plugin

import com.chattylabs.plugin.model.GitSettings
import com.chattylabs.plugin.model.Version
import com.chattylabs.plugin.model.VersionSettings
import org.gradle.api.Action

class VersioningExtension {

    private Version version
    private VersionSettings vSettings = new VersionSettings()
    private GitSettings gSettings = new GitSettings()

    VersioningExtension(Version version) {
        this.version = version
    }

    String version() {
        return this.version
    }

    void versionSetting(Action<? super VersionSettings> settingsAction) {
        settingsAction.execute(vSettings)
    }

    void gitSetting(Action<? super GitSettings> gitAction) {
        gitAction.execute(gSettings)
    }

    VersionSettings versionSettings() {
        return vSettings
    }

    GitSettings gitSettings() {
        return gSettings
    }
}
