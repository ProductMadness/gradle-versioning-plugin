package com.productmadness.plugin.internal

class DefaultOnGitCommandFailure implements OnGitCommandFailure {

    DefaultOnGitCommandFailure() {}

    @Override
    void onFailure(String text) {
        throw new RuntimeException(text)
    }
}
