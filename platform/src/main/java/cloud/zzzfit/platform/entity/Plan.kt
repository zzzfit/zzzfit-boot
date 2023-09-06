package cloud.zzzfit.platform.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import cloud.zzzfit.data.entity.Managed
@Entity
class Subscription: Managed<Long>() {
    @Id
    var id: Long = 0
}