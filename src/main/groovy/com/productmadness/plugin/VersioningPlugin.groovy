package com.productmadness.plugin

import com.productmadness.plugin.util.PluginUtil
import com.productmadness.plugin.util.VersionCache
import org.gradle.api.Plugin
import org.gradle.api.Project

class VersioningPlugin implements Plugin<Project> {

    Project mProject

    @Override
    void apply(Project project) {
        mProject = project
        loadVersionProperties()
    }

    def loadVersionProperties() {
        mProject.extensions.create(PluginUtil.GRADLE_EXTENSION_NAME, VersioningExtension.class, mProject, mProject.objects)
        mProject.tasks.create("pushVersion", VersionTagCreator.class, task -> {
            task.setGroup(PluginUtil.TASK_GROUP)
            task.setDescription("Creates a new project version tag.")
        })
        mProject.tasks.create("pullVersion", UpdateVersionTask.class, task -> {
            task.setGroup(PluginUtil.TASK_GROUP)
            task.setDescription("Updates to the last project version.")
        })
        VersionCache.reset()
    }
}
