package core.dailysummary.api.support

import org.springframework.restdocs.snippet.Attributes

class RestDocsUtils {
    companion object {
        const val DEFAULT_DATE_FORMAT = "2024-01-01"
        const val DEFAULT_DATE_TIME_FORMAT = "2024-01-01T00:00:00"

        fun emptyFormat(): Attributes.Attribute {
            return Attributes.key("format").value("")
        }

        fun emptyDefaultValue(): Attributes.Attribute {
            return Attributes.key("defaultValue").value("")
        }
    }

}
