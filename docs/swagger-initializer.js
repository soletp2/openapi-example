window.onload = () => {
  window.ui = SwaggerUIBundle({
    url: "../openapi.yaml",        // points to your spec in the repo root
    dom_id: "#swagger-ui",
    deepLinking: true,
    presets: [SwaggerUIBundle.presets.apis, SwaggerUIStandalonePreset],
    layout: "StandaloneLayout"
  });
};
