package main;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class MyFXML {
    private final Injector injector;

    /**
     *
     * @param injector injector
     */
    public MyFXML(Injector injector) {
        this.injector = injector;
    }

    /**
     *
     * @param c c
     * @param parts parts
     * @return pair
     * @param <T> type
     */
    public <T> Pair<T, Parent> load(Class<T> c, String... parts) {
        try {
            var loader = new FXMLLoader(getLocation(parts), null, null, new MyFactory(), StandardCharsets.UTF_8);
            Parent parent = loader.load();
            T ctrl = loader.getController();
            return new Pair<>(ctrl, parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param parts parts
     * @return url
     */
    private URL getLocation(String... parts) {
        var path = Path.of("", parts).toString();
        return MyFXML.class.getClassLoader().getResource(path);
    }

    private class MyFactory implements BuilderFactory, Callback<Class<?>, Object> {

        /**
         *
         * @param type the given type or null
         *
         * @return builder
         */
        @Override
        @SuppressWarnings("rawtypes")
        public Builder<?> getBuilder(Class<?> type) {
            return (Builder) () -> injector.getInstance(type);
        }

        /**
         *
         * @param type The single argument upon which the returned value should be
         *      determined.
         * @return obj
         */
        @Override
        public Object call(Class<?> type) {
            return injector.getInstance(type);
        }
    }
}
