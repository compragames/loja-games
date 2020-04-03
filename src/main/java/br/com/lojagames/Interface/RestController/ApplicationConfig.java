package br.com.lojagames.Interface.RestController;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("compra-games")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(new AplicationBinder());
        addRest();
        register(CORSResponseFilter.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);

    }

    private void addRest() {
        register(br.com.lojagames.Interface.Controller.RestProduto.class);
        register(br.com.lojagames.Interface.Controller.RestCliente.class);
        register(br.com.lojagames.Interface.Controller.RestFuncionario.class);
        register(br.com.lojagames.Interface.Controller.RestAcesso.class);
        register(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        register(MultiPartFeature.class);
    }

}
