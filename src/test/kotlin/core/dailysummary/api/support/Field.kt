package core.dailysummary.api.support

import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.snippet.Attributes

open class Field(
    val descriptor: FieldDescriptor,
) {
    val isIgnored: Boolean = descriptor.isIgnored
    val isOptional: Boolean = descriptor.isOptional

    open infix fun means(value: String): Field {
        descriptor.description(value)
        return this
    }

    open infix fun attributes(block: Field.() -> Unit): Field {
        block()
        return this
    }

    open infix fun formattedAs(value: String): Field {
        descriptor.attributes(Attributes.key("format").value(value))
        return this
    }

    open infix fun isOptional(value: Boolean): Field {
        if (value) descriptor.optional()
        return this
    }

    open infix fun isIgnored(value: Boolean): Field {
        if (value) descriptor.ignored()
        return this
    }
}
