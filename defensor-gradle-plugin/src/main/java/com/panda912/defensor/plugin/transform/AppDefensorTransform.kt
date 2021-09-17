package com.panda912.defensor.plugin.transform

import com.android.build.api.transform.QualifiedContent
import com.android.build.gradle.internal.pipeline.TransformManager
import com.panda912.defensor.plugin.Global

/**
 * Created by panda on 2021/8/17 14:12
 */
class AppDefensorTransform(global: Global) : DefensorTransform(global) {
  override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
    return TransformManager.SCOPE_FULL_PROJECT
  }
}