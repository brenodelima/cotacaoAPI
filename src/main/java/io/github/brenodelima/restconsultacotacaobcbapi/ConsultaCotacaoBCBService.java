package io.github.brenodelima.restconsultacotacaobcbapi;

import io.github.brenodelima.model.CotacaoDolar;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient
public interface ConsultaCotacaoBCBService {
    @GET
    @Path("/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CotacaoDolar> pesquisarCotacaoDolar(@PathParam String data);
}
