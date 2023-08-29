package cloud.zzzfit.upms

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BooleanToIntegerConverter : AttributeConverter<Boolean, Int> {
    override fun convertToDatabaseColumn(attribute: Boolean?): Int {
        TODO("Not yet implemented")
    }

    override fun convertToEntityAttribute(dbData: Int?): Boolean {
        TODO("Not yet implemented")
    }
}