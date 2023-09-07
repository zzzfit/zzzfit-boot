package cloud.zzzfit.platform.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import cloud.zzzfit.data.entity.Managed
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
class Subscription: Managed<Long>() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}