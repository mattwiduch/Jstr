/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package eu.redray.jstr.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import eu.redray.JokeTeller;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokesApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jstr.redray.eu",
                ownerName = "backend.jstr.redray.eu",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that sends a joke fetched from Java library
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData((new JokeTeller()).tellJoke());
        return response;
    }

}
