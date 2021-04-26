package com.example.demo.domain

import javax.persistence.*

@Entity
@Table(name =  "orders")
class Orders(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0L,

        @Column
        var name: String,

        @Column
        var count: Int
) {
        override fun toString(): String {
                return "Orders(id=$id, name='$name', count=$count)"
        }

        override fun equals(other: Any?): Boolean {
//                return false
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Orders

                if (id != other.id) return false
                if (name != other.name) return false
                if (count != other.count) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id.hashCode()
                result = 31 * result + name.hashCode()
                result = 31 * result + count
                return result
        }


}