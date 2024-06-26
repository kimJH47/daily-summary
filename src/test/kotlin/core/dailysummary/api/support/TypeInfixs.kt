package core.dailysummary.api.support

import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation

infix fun String.type(docsFieldType: DocsFieldType): Field {
    val field = createField(this, docsFieldType.type)
    when (docsFieldType) {
        is DATE -> field formattedAs RestDocsUtils.DEFAULT_DATE_FORMAT
        is DATETIME -> field formattedAs RestDocsUtils.DEFAULT_DATE_TIME_FORMAT
        else -> {}
    }
    return field
}

private fun createField(value: String, type: JsonFieldType, optional: Boolean = false): Field {
    val descriptor = PayloadDocumentation.fieldWithPath(value)
        .type(type)
        .attributes(RestDocsUtils.emptyFormat(), RestDocsUtils.emptyDefaultValue())
        .description("")
    if (optional) descriptor.optional()

    return Field(descriptor)
}
