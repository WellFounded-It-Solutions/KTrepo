package com.navigaglobal.mobile

import com.bumptech.glide.module.AppGlideModule

/**
 * Custom [AppGlideModule].
 *
 * Exists to avoid silently ignoring [com.bumptech.glide.module.LibraryGlideModule]s.
 *
 * Reason [com.bumptech.glide.Glide]:
 * Log.w(
 *      TAG,
 *      "Failed to find GeneratedAppGlideModule. You should include an"
 *          + " annotationProcessor compile dependency on com.github.bumptech.glide:compiler"
 *          + " in your application and a @GlideModule annotated AppGlideModule implementation"
 *          + " or LibraryGlideModules will be silently ignored");
 */
@com.bumptech.glide.annotation.GlideModule
class GlideModule : AppGlideModule()