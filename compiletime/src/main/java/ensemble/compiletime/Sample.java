
package ensemble.compiletime;

import javafx.application.ConditionalFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Descriptor for a ensemble sample. Everything the ui needs is determined at
 * compile time from the sample sources and stored in these Sample objects so
 * we don't have to calculate anything at runtime.
 */
public class Sample {

    // =============== BASICS ==================================================

    public String name;
    public String description;
    public String ensemblePath;

//    private final String packageName;
//    private final String className;

    // =============== SOURCES & RESOURCES =====================================

    /** The base URI for all the source files and resources for this sample. */
    public String baseUri;
    /** All the files needed by this sample. Relative to the sample base URI. */
    public List<String> resourceUrls = new ArrayList<>();
    /** The URL for the source of the sample main file. Relative to the sample base URI */
    public String mainFileUrl;
    /** Full classpath for sample's application class */
    public String appClass;
    /** ClassPath Url for preview image of size 206x152 */
    public String previewUrl;
    /** List of properties in the sample that can be played with */
    public final List<PlaygroundProperty> playgroundProperties = new ArrayList<>();
    /** List of conditional features the platform must support to run certain samples */
    public final List<ConditionalFeature> conditionalFeatures = new ArrayList<>();
    /** If true, then the sample runs on embedded platform  */
    public boolean runsOnEmbedded = false;

    // =============== RELATED =================================================

    /** Array of classpaths to related api docs. */
    public List<String> apiClasspaths = new ArrayList<>();
    /** Array of urls to related (non-api) docs. */
    public List<URL> docsUrls = new ArrayList<>();
    /** Array of ensemble paths to related samples. */
    public List<String> relatesSamplePaths = new ArrayList<>();

    @Override public String toString() {
        return "Sample{" +
                 "\n         name                 =" + name +
                ",\n         description          =" + description +
                ",\n         ensemblePath         =" + ensemblePath +
                ",\n         previewUrl           =" + previewUrl +
                ",\n         baseUri              =" + baseUri +
                ",\n         resourceUrls         =" + resourceUrls +
                ",\n         mainFileUrl          =" + mainFileUrl +
                ",\n         appClass             =" + appClass +
                ",\n         apiClasspaths        =" + apiClasspaths +
                ",\n         docsUrls             =" + docsUrls +
                ",\n         relatesSamplePaths   =" + relatesSamplePaths +
                ",\n         playgroundProperties =" + playgroundProperties +
                ",\n         conditionalFeatures  =" + conditionalFeatures +
                ",\n         runsOnEmbedded       =" + runsOnEmbedded +
                '}';
    }

    public static class URL {
        public final String url;
        public final String name;

        public URL(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public URL(String raw) {
            int index = raw.indexOf(' ');
            if (index == -1) {
                name = url = raw;
            } else {
                url = raw.substring(0, index);
                name = raw.substring(index + 1);
            }
        }
    }

    public static class PlaygroundProperty {
        public final String fieldName;
        public final String propertyName;
        public final Map<String,String> properties;

        public PlaygroundProperty(String fieldName, String propertyName, Map<String,String> properties) {
            this.fieldName = fieldName;
            this.propertyName = propertyName;
            this.properties = properties;
        }

        @Override public String toString() {
            return fieldName+"."+propertyName+" ("+properties+")";
        }
    }
}
