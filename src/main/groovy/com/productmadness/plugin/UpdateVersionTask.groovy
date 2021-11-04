package com.productmadness.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class UpdateVersionTask extends DefaultTask {

    @TaskAction
    void performTask() {
        new VersioningTask(project).updateVersionProperties()
    }
}
