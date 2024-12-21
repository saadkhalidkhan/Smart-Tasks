package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final CoroutinesLibraryAccessors laccForCoroutinesLibraryAccessors = new CoroutinesLibraryAccessors(owner);
    private final GoogleLibraryAccessors laccForGoogleLibraryAccessors = new GoogleLibraryAccessors(owner);
    private final HiltLibraryAccessors laccForHiltLibraryAccessors = new HiltLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final LifecycleLibraryAccessors laccForLifecycleLibraryAccessors = new LifecycleLibraryAccessors(owner);
    private final LoggingLibraryAccessors laccForLoggingLibraryAccessors = new LoggingLibraryAccessors(owner);
    private final PlayLibraryAccessors laccForPlayLibraryAccessors = new PlayLibraryAccessors(owner);
    private final Retrofit2LibraryAccessors laccForRetrofit2LibraryAccessors = new Retrofit2LibraryAccessors(owner);
    private final UiLibraryAccessors laccForUiLibraryAccessors = new UiLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for coillib (io.coil-kt:coil-compose)
     * with versionRef 'coil'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCoillib() {
            return create("coillib");
    }

        /**
         * Creates a dependency provider for constraintLayoutCompose (androidx.constraintlayout:constraintlayout-compose)
     * with versionRef 'constraintLayout'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConstraintLayoutCompose() {
            return create("constraintLayoutCompose");
    }

        /**
         * Creates a dependency provider for material (androidx.compose.material:material)
     * with no version specified
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("material");
    }

        /**
         * Creates a dependency provider for material3 (androidx.compose.material3:material3)
     * with no version specified
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("material3");
    }

        /**
         * Creates a dependency provider for okhttp (com.squareup.okhttp3:okhttp)
     * with versionRef 'okhttp'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() {
            return create("okhttp");
    }

        /**
         * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
     * with versionRef 'retrofit'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRetrofit() {
            return create("retrofit");
    }

        /**
         * Creates a dependency provider for systemUiController (com.google.accompanist:accompanist-systemuicontroller)
     * with versionRef 'systemUiController'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSystemUiController() {
            return create("systemUiController");
    }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() {
        return laccForAndroidLibraryAccessors;
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Returns the group of libraries at coroutines
     */
    public CoroutinesLibraryAccessors getCoroutines() {
        return laccForCoroutinesLibraryAccessors;
    }

    /**
     * Returns the group of libraries at google
     */
    public GoogleLibraryAccessors getGoogle() {
        return laccForGoogleLibraryAccessors;
    }

    /**
     * Returns the group of libraries at hilt
     */
    public HiltLibraryAccessors getHilt() {
        return laccForHiltLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at lifecycle
     */
    public LifecycleLibraryAccessors getLifecycle() {
        return laccForLifecycleLibraryAccessors;
    }

    /**
     * Returns the group of libraries at logging
     */
    public LoggingLibraryAccessors getLogging() {
        return laccForLoggingLibraryAccessors;
    }

    /**
     * Returns the group of libraries at play
     */
    public PlayLibraryAccessors getPlay() {
        return laccForPlayLibraryAccessors;
    }

    /**
     * Returns the group of libraries at retrofit2
     */
    public Retrofit2LibraryAccessors getRetrofit2() {
        return laccForRetrofit2LibraryAccessors;
    }

    /**
     * Returns the group of libraries at ui
     */
    public UiLibraryAccessors getUi() {
        return laccForUiLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (com.google.android.material:material)
         * with versionRef 'material'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() {
                return create("android.material");
        }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxAppcompatLibraryAccessors laccForAndroidxAppcompatLibraryAccessors = new AndroidxAppcompatLibraryAccessors(owner);
        private final AndroidxHiltLibraryAccessors laccForAndroidxHiltLibraryAccessors = new AndroidxHiltLibraryAccessors(owner);
        private final AndroidxJunitLibraryAccessors laccForAndroidxJunitLibraryAccessors = new AndroidxJunitLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
         * with versionRef 'ktx'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.ktx");
        }

            /**
             * Creates a dependency provider for material3 (androidx.compose.material3:material3)
         * with version '1.1.2'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial3() {
                return create("androidx.material3");
        }

            /**
             * Creates a dependency provider for monitor (androidx.test:monitor)
         * with version '1.6.1'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMonitor() {
                return create("androidx.monitor");
        }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.appcompat
         */
        public AndroidxAppcompatLibraryAccessors getAppcompat() {
            return laccForAndroidxAppcompatLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.hilt
         */
        public AndroidxHiltLibraryAccessors getHilt() {
            return laccForAndroidxHiltLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.junit
         */
        public AndroidxJunitLibraryAccessors getJunit() {
            return laccForAndroidxJunitLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.navigation
         */
        public AndroidxNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxNavigationLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.activity:activity-compose)
         * with versionRef 'activityCompose'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.activity.compose");
        }

    }

    public static class AndroidxAppcompatLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxAppcompatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
         * with versionRef 'appcompat'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.appcompat");
        }

            /**
             * Creates a dependency provider for normal (androidx.activity:activity-ktx)
         * with versionRef 'appcompatActivity'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNormal() {
                return create("androidx.appcompat.normal");
        }

    }

    public static class AndroidxHiltLibraryAccessors extends SubDependencyFactory {
        private final AndroidxHiltNavigationLibraryAccessors laccForAndroidxHiltNavigationLibraryAccessors = new AndroidxHiltNavigationLibraryAccessors(owner);

        public AndroidxHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.hilt.navigation
         */
        public AndroidxHiltNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxHiltNavigationLibraryAccessors;
        }

    }

    public static class AndroidxHiltNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxHiltNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.hilt:hilt-navigation-compose)
         * with versionRef 'hiltNavigationCompose'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.hilt.navigation.compose");
        }

    }

    public static class AndroidxJunitLibraryAccessors extends SubDependencyFactory {

        public AndroidxJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.test.ext:junit-ktx)
         * with version '1.1.5'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.junit.ktx");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.viewmodel
         */
        public AndroidxLifecycleViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxLifecycleViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-viewmodel-compose)
         * with versionRef 'lifecycle'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.lifecycle.viewmodel.compose");
        }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.navigation:navigation-compose)
         * with versionRef 'navigationCompose'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.navigation.compose");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (androidx.compose:compose-bom)
         * with versionRef 'compose.bom'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() {
                return create("compose.bom");
        }

    }

    public static class CoroutinesLibraryAccessors extends SubDependencyFactory {
        private final CoroutinesPlayLibraryAccessors laccForCoroutinesPlayLibraryAccessors = new CoroutinesPlayLibraryAccessors(owner);

        public CoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
         * with versionRef 'coroutinesCore'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("coroutines.core");
        }

        /**
         * Returns the group of libraries at coroutines.play
         */
        public CoroutinesPlayLibraryAccessors getPlay() {
            return laccForCoroutinesPlayLibraryAccessors;
        }

    }

    public static class CoroutinesPlayLibraryAccessors extends SubDependencyFactory {

        public CoroutinesPlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for services (org.jetbrains.kotlinx:kotlinx-coroutines-play-services)
         * with versionRef 'coroutinesPlay'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServices() {
                return create("coroutines.play.services");
        }

    }

    public static class GoogleLibraryAccessors extends SubDependencyFactory {
        private final GoogleMapLibraryAccessors laccForGoogleMapLibraryAccessors = new GoogleMapLibraryAccessors(owner);

        public GoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at google.map
         */
        public GoogleMapLibraryAccessors getMap() {
            return laccForGoogleMapLibraryAccessors;
        }

    }

    public static class GoogleMapLibraryAccessors extends SubDependencyFactory {
        private final GoogleMapComposeLibraryAccessors laccForGoogleMapComposeLibraryAccessors = new GoogleMapComposeLibraryAccessors(owner);

        public GoogleMapLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at google.map.compose
         */
        public GoogleMapComposeLibraryAccessors getCompose() {
            return laccForGoogleMapComposeLibraryAccessors;
        }

    }

    public static class GoogleMapComposeLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public GoogleMapComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (com.google.maps.android:maps-compose)
         * with versionRef 'googleMap'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("google.map.compose");
        }

            /**
             * Creates a dependency provider for utils (com.google.maps.android:maps-compose-utils)
         * with versionRef 'googleMap'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUtils() {
                return create("google.map.compose.utils");
        }

            /**
             * Creates a dependency provider for widgets (com.google.maps.android:maps-compose-widgets)
         * with versionRef 'googleMap'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWidgets() {
                return create("google.map.compose.widgets");
        }

    }

    public static class HiltLibraryAccessors extends SubDependencyFactory {

        public HiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.google.dagger:hilt-android)
         * with versionRef 'hilt'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("hilt.android");
        }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-compiler)
         * with versionRef 'hilt'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("hilt.compiler");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCollectionsLibraryAccessors laccForKotlinxCollectionsLibraryAccessors = new KotlinxCollectionsLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.collections
         */
        public KotlinxCollectionsLibraryAccessors getCollections() {
            return laccForKotlinxCollectionsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at kotlinx.serialization
         */
        public KotlinxSerializationLibraryAccessors getSerialization() {
            return laccForKotlinxSerializationLibraryAccessors;
        }

    }

    public static class KotlinxCollectionsLibraryAccessors extends SubDependencyFactory {

        public KotlinxCollectionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for immutable (org.jetbrains.kotlinx:kotlinx-collections-immutable)
         * with versionRef 'kotlinxCollectionsImmutable'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getImmutable() {
                return create("kotlinx.collections.immutable");
        }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for json (org.jetbrains.kotlinx:kotlinx-serialization-json)
         * with versionRef 'kotlinxSerializationJson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() {
                return create("kotlinx.serialization.json");
        }

    }

    public static class LifecycleLibraryAccessors extends SubDependencyFactory {
        private final LifecycleRuntimeLibraryAccessors laccForLifecycleRuntimeLibraryAccessors = new LifecycleRuntimeLibraryAccessors(owner);

        public LifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for process (androidx.lifecycle:lifecycle-process)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProcess() {
                return create("lifecycle.process");
        }

        /**
         * Returns the group of libraries at lifecycle.runtime
         */
        public LifecycleRuntimeLibraryAccessors getRuntime() {
            return laccForLifecycleRuntimeLibraryAccessors;
        }

    }

    public static class LifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public LifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-runtime-compose)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("lifecycle.runtime.compose");
        }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("lifecycle.runtime.ktx");
        }

    }

    public static class LoggingLibraryAccessors extends SubDependencyFactory {

        public LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for interceptor (com.squareup.okhttp3:logging-interceptor)
         * with versionRef 'loggingInterceptor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInterceptor() {
                return create("logging.interceptor");
        }

    }

    public static class PlayLibraryAccessors extends SubDependencyFactory {
        private final PlayServicesLibraryAccessors laccForPlayServicesLibraryAccessors = new PlayServicesLibraryAccessors(owner);

        public PlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at play.services
         */
        public PlayServicesLibraryAccessors getServices() {
            return laccForPlayServicesLibraryAccessors;
        }

    }

    public static class PlayServicesLibraryAccessors extends SubDependencyFactory {

        public PlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for location (com.google.android.gms:play-services-location)
         * with version '21.0.1'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLocation() {
                return create("play.services.location");
        }

    }

    public static class Retrofit2LibraryAccessors extends SubDependencyFactory {
        private final Retrofit2GsonLibraryAccessors laccForRetrofit2GsonLibraryAccessors = new Retrofit2GsonLibraryAccessors(owner);

        public Retrofit2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at retrofit2.gson
         */
        public Retrofit2GsonLibraryAccessors getGson() {
            return laccForRetrofit2GsonLibraryAccessors;
        }

    }

    public static class Retrofit2GsonLibraryAccessors extends SubDependencyFactory {

        public Retrofit2GsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for converter (com.squareup.retrofit2:converter-gson)
         * with versionRef 'retrofit2Converter'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConverter() {
                return create("retrofit2.gson.converter");
        }

    }

    public static class UiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final UiTestLibraryAccessors laccForUiTestLibraryAccessors = new UiTestLibraryAccessors(owner);
        private final UiToolingLibraryAccessors laccForUiToolingLibraryAccessors = new UiToolingLibraryAccessors(owner);

        public UiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ui");
        }

            /**
             * Creates a dependency provider for graphics (androidx.compose.ui:ui-graphics)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGraphics() {
                return create("ui.graphics");
        }

        /**
         * Returns the group of libraries at ui.test
         */
        public UiTestLibraryAccessors getTest() {
            return laccForUiTestLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ui.tooling
         */
        public UiToolingLibraryAccessors getTooling() {
            return laccForUiToolingLibraryAccessors;
        }

    }

    public static class UiTestLibraryAccessors extends SubDependencyFactory {

        public UiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for manifest (androidx.compose.ui:ui-test-manifest)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getManifest() {
                return create("ui.test.manifest");
        }

    }

    public static class UiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public UiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ui.tooling");
        }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() {
                return create("ui.tooling.preview");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: activityCompose (1.8.0-rc01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivityCompose() { return getVersion("activityCompose"); }

            /**
             * Returns the version associated to this alias: androidGradlePlugin (8.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidGradlePlugin() { return getVersion("androidGradlePlugin"); }

            /**
             * Returns the version associated to this alias: androidxTestEspresso (3.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidxTestEspresso() { return getVersion("androidxTestEspresso"); }

            /**
             * Returns the version associated to this alias: androidxTestJunit (1.1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidxTestJunit() { return getVersion("androidxTestJunit"); }

            /**
             * Returns the version associated to this alias: appcompat (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompat() { return getVersion("appcompat"); }

            /**
             * Returns the version associated to this alias: appcompatActivity (1.7.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompatActivity() { return getVersion("appcompatActivity"); }

            /**
             * Returns the version associated to this alias: biometric (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBiometric() { return getVersion("biometric"); }

            /**
             * Returns the version associated to this alias: browser (1.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBrowser() { return getVersion("browser"); }

            /**
             * Returns the version associated to this alias: coil (2.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoil() { return getVersion("coil"); }

            /**
             * Returns the version associated to this alias: constraintLayout (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConstraintLayout() { return getVersion("constraintLayout"); }

            /**
             * Returns the version associated to this alias: coroutinesCore (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutinesCore() { return getVersion("coroutinesCore"); }

            /**
             * Returns the version associated to this alias: coroutinesPlay (1.7.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutinesPlay() { return getVersion("coroutinesPlay"); }

            /**
             * Returns the version associated to this alias: dataStore (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDataStore() { return getVersion("dataStore"); }

            /**
             * Returns the version associated to this alias: disparcherPermission (4.9.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDisparcherPermission() { return getVersion("disparcherPermission"); }

            /**
             * Returns the version associated to this alias: googleAuth (20.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGoogleAuth() { return getVersion("googleAuth"); }

            /**
             * Returns the version associated to this alias: googleConnect (1.1.0-alpha04)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGoogleConnect() { return getVersion("googleConnect"); }

            /**
             * Returns the version associated to this alias: googleFit (21.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGoogleFit() { return getVersion("googleFit"); }

            /**
             * Returns the version associated to this alias: googleMap (3.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGoogleMap() { return getVersion("googleMap"); }

            /**
             * Returns the version associated to this alias: hilt (2.48)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHilt() { return getVersion("hilt"); }

            /**
             * Returns the version associated to this alias: hiltNavigationCompose (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHiltNavigationCompose() { return getVersion("hiltNavigationCompose"); }

            /**
             * Returns the version associated to this alias: kotlinCompilerExtension (1.5.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinCompilerExtension() { return getVersion("kotlinCompilerExtension"); }

            /**
             * Returns the version associated to this alias: kotlinPlugin (1.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinPlugin() { return getVersion("kotlinPlugin"); }

            /**
             * Returns the version associated to this alias: kotlinxCollectionsImmutable (0.3.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxCollectionsImmutable() { return getVersion("kotlinxCollectionsImmutable"); }

            /**
             * Returns the version associated to this alias: kotlinxSerializationJson (1.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxSerializationJson() { return getVersion("kotlinxSerializationJson"); }

            /**
             * Returns the version associated to this alias: ksp (1.9.0-1.0.12)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKsp() { return getVersion("ksp"); }

            /**
             * Returns the version associated to this alias: ktx (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtx() { return getVersion("ktx"); }

            /**
             * Returns the version associated to this alias: lifecycle (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("lifecycle"); }

            /**
             * Returns the version associated to this alias: loggingInterceptor (4.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLoggingInterceptor() { return getVersion("loggingInterceptor"); }

            /**
             * Returns the version associated to this alias: material (1.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

            /**
             * Returns the version associated to this alias: navigationCompose (2.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigationCompose() { return getVersion("navigationCompose"); }

            /**
             * Returns the version associated to this alias: okhttp (5.0.0-alpha.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: oneSignal (4.8.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOneSignal() { return getVersion("oneSignal"); }

            /**
             * Returns the version associated to this alias: retrofit (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofit() { return getVersion("retrofit"); }

            /**
             * Returns the version associated to this alias: retrofit2Converter (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofit2Converter() { return getVersion("retrofit2Converter"); }

            /**
             * Returns the version associated to this alias: systemUiController (0.27.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSystemUiController() { return getVersion("systemUiController"); }

            /**
             * Returns the version associated to this alias: testJunit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTestJunit() { return getVersion("testJunit"); }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() {
            return vaccForComposeVersionAccessors;
        }

    }

    public static class ComposeVersionAccessors extends VersionFactory  {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: compose.bom (2023.09.02)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBom() { return getVersion("compose.bom"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComPluginAccessors paccForComPluginAccessors = new ComPluginAccessors(providers, config);
        private final HiltPluginAccessors paccForHiltPluginAccessors = new HiltPluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final KspPluginAccessors paccForKspPluginAccessors = new KspPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.android
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.com
         */
        public ComPluginAccessors getCom() {
            return paccForComPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.hilt
         */
        public HiltPluginAccessors getHilt() {
            return paccForHiltPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.ksp
         */
        public KspPluginAccessors getKsp() {
            return paccForKspPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for android.application to the plugin id 'com.android.application'
             * with versionRef 'androidGradlePlugin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

    }

    public static class ComPluginAccessors extends PluginFactory {
        private final ComAndroidPluginAccessors paccForComAndroidPluginAccessors = new ComAndroidPluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.android
         */
        public ComAndroidPluginAccessors getAndroid() {
            return paccForComAndroidPluginAccessors;
        }

    }

    public static class ComAndroidPluginAccessors extends PluginFactory {

        public ComAndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.android.library to the plugin id 'com.android.library'
             * with versionRef 'androidGradlePlugin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("com.android.library"); }

    }

    public static class HiltPluginAccessors extends PluginFactory {

        public HiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for hilt.android to the plugin id 'com.google.dagger.hilt.android'
             * with versionRef 'hilt'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("hilt.android"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * with versionRef 'kotlinPlugin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

            /**
             * Creates a plugin provider for kotlin.serialization to the plugin id 'org.jetbrains.kotlin.plugin.serialization'
             * with versionRef 'kotlinPlugin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSerialization() { return createPlugin("kotlin.serialization"); }

    }

    public static class KspPluginAccessors extends PluginFactory {

        public KspPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for ksp.android to the plugin id 'com.google.devtools.ksp'
             * with versionRef 'ksp'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("ksp.android"); }

    }

}
