package io.github.brenodelima.resource;

import io.github.brenodelima.exception.RequisicaoInvalidaException;
import io.github.brenodelima.model.CotacaoDolar;
import io.github.brenodelima.service.CotacaoDolarService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/cotacaodolar")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Tag(name = "Cotação Dólar.", description = "Endpoints para cotação do dólar.")
@ApplicationScoped
public class CotacaoDolarResource {
    @Inject
    CotacaoDolarService service;

    @GET
    @Path("/{data}")
    @Operation(
        summary = "Consultar a cotação do dolar.",
	    description = "Informe uma data válida de um dia útil, no formato dd-MM-yyyy para receber a cotação do dólar."
    )
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON,
                schema = @Schema(implementation = CotacaoDolar.class, type = SchemaType.DEFAULT)))
    @APIResponse(responseCode = "500", description = "Serviço indisponível, tente novamente mais tarde",
            content = @Content(mediaType = APPLICATION_JSON,
                schema = @Schema(implementation = RequisicaoInvalidaException.class, type = SchemaType.DEFAULT)))
    public Response consultarCotacaoDolar(@Parameter(description = "Data da cotação desejada.", required = true)
                                          @PathParam("data") String data) {
        CotacaoDolar retorno = service.consultarCotacaoDolar(data);
        return Response.status(Response.Status.OK).entity(retorno).build();
    }
}
