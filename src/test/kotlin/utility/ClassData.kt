package utility

import kotlinx.serialization.Serializable

@Serializable
data class ClassData(
  val className: String,
  val methods: List<MethodData>
)
