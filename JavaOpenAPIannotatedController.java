package com.example.clothingstore.api.cart;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Sample Cart controller derived from the OpenAPI YAML (Cart tag only).
 * Note: This is a portfolio-style controller. Replace the stubbed responses with real service calls.
 */
@RestController
@RequestMapping("/v1")
@Tag(name = "Cart", description = "Cart endpoints")
@Validated
public class CartController {

    // -------------------------
    // GET /cart
    // -------------------------
    @Operation(
            summary = "Get current cart",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cart details",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Missing or invalid access token",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/cart")
    public ResponseEntity<Cart> getCurrentCart() {
        // TODO: return cart for current user
        return ResponseEntity.ok(sampleCart());
    }

    // -------------------------
    // POST /cart
    // -------------------------
    @Operation(
            summary = "Add item to cart",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated cart",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Missing or invalid access token",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Not enough stock for requested quantity",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping("/cart")
    public ResponseEntity<Cart> addToCart(
            @RequestBody(
                    required = true,
                    description = "SKU + quantity to add",
                    content = @Content(schema = @Schema(implementation = AddToCartRequest.class))
            )
            @Valid @org.springframework.web.bind.annotation.RequestBody AddToCartRequest request
    ) {
        // TODO: add item to cart for current user
        return ResponseEntity.ok(sampleCart());
    }

    // -------------------------
    // DELETE /cart
    // -------------------------
    @Operation(
            summary = "Clear cart",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cart cleared"),
            @ApiResponse(
                    responseCode = "401",
                    description = "Missing or invalid access token",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/cart")
    public ResponseEntity<Void> clearCart() {
        // TODO: clear current user's cart
        return ResponseEntity.noContent().build();
    }

    // -------------------------
    // PATCH /cart/items/{sku}
    // -------------------------
    @Operation(
            summary = "Update cart item quantity",
            description = "Updates quantity for a cart item by SKU. Set quantity to 0 to remove the item.",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated cart",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Missing or invalid access token",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Resource not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Not enough stock for requested quantity",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PatchMapping("/cart/items/{sku}")
    public ResponseEntity<Cart> updateCartItemQuantity(
            @PathVariable("sku") @NotBlank String sku,
            @RequestBody(
                    required = true,
                    description = "New quantity (0 removes item)",
                    content = @Content(schema = @Schema(implementation = UpdateCartItemRequest.class))
            )
            @Valid @org.springframework.web.bind.annotation.RequestBody UpdateCartItemRequest request
    ) {
        // TODO: update qty for the SKU in current user's cart
        return ResponseEntity.ok(sampleCart());
    }