package gestorDeInventariosYVentas.example.controller.controllerDoc;

import gestorDeInventariosYVentas.example.dto.input.CustomerInputDTO;
import gestorDeInventariosYVentas.example.dto.output.CustomerOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface CustomerRestControllerDoc {
    @Operation(
            summary = "Create customer",
            description = "This method allows creating a new customer.",
            requestBody = @RequestBody(
                    description = "requires receiving the following attributes: name, email, address, phoneNumber",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerInputDTO.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Example input",
                                            value = "{" +
                                                    "\"name\":\"Julian Contreras\"," +
                                                    "\"email\":\"contreju@gmail.com\"," +
                                                    "\"address\":\"mz 22 cs 3\"," +
                                                    "\"phoneNumber\":\"564897\"," +
                                                    "}"
                                    )
                            }
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example response",
                                                    value = "{" +
                                                            "\"id\": 1," +
                                                            "\"name\":\"Julian Contreras\"," +
                                                            "\"email\":\"contreju@gmail.com\"," +
                                                            "\"address\":\"mz 22 cs 3\"," +
                                                            "\"phoneNumber\":\"564897\"," +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    CustomerOutputDTO createCustomer(CustomerInputDTO customerInputDTO);
}
