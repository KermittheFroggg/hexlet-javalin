package gg.jte.generated.ondemand.courses;
public final class JtenewGenerated {
	public static final String JTE_NAME = "courses/new.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n<form action=\"/courses\" method=\"post\">\n    <div>\n        <label>\n            Название\n            <input type=\"text\" name=\"name\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Описание\n            <input type=\"description\" required name=\"description\" />\n        </label>\n    </div>\n    <input type=\"submit\" value=\"Добавить\" />\n</form>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
