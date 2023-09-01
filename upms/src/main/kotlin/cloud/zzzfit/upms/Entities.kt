package cloud.zzzfit.upms

import jakarta.persistence.*
import java.io.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime


@Entity
class Oauth2AuthorizationConsent  {
    @Embeddable
    class Id : Serializable {
        @Column(name="registered_client_id",length = 100)
        var id: String? =null

        @Column(name="principal_name",length = 200, nullable = false)
        var principalName: String? =null
    }

    @EmbeddedId
    val id: Id? = null

    @Column(length = 1000, nullable = false)
    var authorities: String? =null
}

@Entity
class Oauth2Authorization {

    @Column(length = 100)
    @Id
//    @GeneratedValue
    var id: String? =null

    @Column(name="registered_client_id", length = 100, nullable = false)
    var registeredClientId :String? = null

    @Column(name="principal_name", length = 200, nullable = false)
    var principalName :String? = null

    @Column(name="authorization_grant_type", length = 100, nullable = false)
    var authorizationGrantType :String? = null

    @Column(name="authorized_scopes", length = 1000)
    var authorizedScopes :String? = null

    @Lob
    @Column(length = 1000)
    var attributes: ByteArray? = null

    @Lob
    @Column(length = 500)
    var state: ByteArray? = null

    @Lob
    @Column(name="authorization_code_value")
    var authorizationCodeValue: ByteArray? = null

    @Column(name="authorization_code_issued_at")
    var authorizationCodeIssuedAt: Timestamp? = null

    @Column(name="authorization_code_expires_at")
    var authorizationCodeExpiresAt: Timestamp? = null

    @Lob
    @Column(name="authorization_code_metadata")
    var authorizationCodeMetadata: ByteArray? = null

    @Column(name="access_token_value")
    var accessTokenValue: ByteArray? = null

    @Column(name="access_token_issued_at")
    var accessTokenExpiresAt: Timestamp? = null

    @Column(name="access_token_expires_at")
    var accessTokenIssuedAt: Timestamp? = null

    @Lob
    @Column(name="access_token_metadata")
    var accessTokenMetadata: ByteArray? = null

    @Column(name="access_token_type", length = 100)
    var accessTokenType: String? = null

    @Column(name="access_token_scopes", length = 100)
    var accessTokenScopes: String? = null

    @Lob
    @Column(name="oidc_id_token_value")
    var oidcIdTokenValue: ByteArray? = null

    @Column(name="oidc_id_token_issued_at")
    var oidcIdTokenExpiresAt: Timestamp? = null

    @Column(name="oidc_id_token_expires_at")
    var oidcIdTokenIssuedAt: Timestamp? = null

    @Lob
    @Column(name="oidc_id_token_metadata")
    var oidcIdTokenMetadata: ByteArray? = null

    @Column(name="refresh_token_value")
    var refreshTokenValue: ByteArray? = null

    @Column(name="refresh_token_issued_at")
    var refreshTokenExpiresAt: Timestamp? = null

    @Column(name="refresh_token_expires_at")
    var refreshTokenIssuedAt: Timestamp? = null

    @Lob
    @Column(name="refresh_token_metadata")
    var refreshTokenMetadata: ByteArray? = null

    @Lob
    @Column(name="user_code_value")
    var userCodeValue: ByteArray? = null

    @Column(name="user_code_issued_at")
    var userCodeExpiresAt: Timestamp? = null

    @Column(name="user_code_expires_at")
    var userCodeIssuedAt: Timestamp? = null

    @Lob
    @Column(name="user_code_metadata")
    var userCodeMetadata: ByteArray? = null

    @Lob
    @Column(name="device_code_value")
    var deviceCodeValue: ByteArray? = null

    @Column(name="device_code_issued_at")
    var deviceCodeExpiresAt: Timestamp? = null

    @Column(name="device_code_expires_at")
    var deviceCodeIssuedAt: Timestamp? = null

    @Lob
    @Column(name="device_code_metadata")
    var deviceCodeMetadata: ByteArray? = null
}

@Entity
class Oauth2RegisteredClient  {
    @Column(length = 100)
    @Id
//    @GeneratedValue
    var id: String? =null

    @Column(name="client_id", length = 100)
    var clientId: String? =null

    @Column(name="client_id_issued_at", nullable = false)
    var clientIdIssuedAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now())

    @Column(name="client_secret", length = 200)
    var clientSecret: String? =null

    @Column(name="client_secret_expires_at")
    var clientSecretExpiresAt: Timestamp?=null

    @Column(name="client_name", length = 200)
    var client_name: String? =null

    @Column(name="client_authentication_methods", length = 1000)
    var clientAuthenticationMethods: String? =null

    @Column(name="authorization_grant_types", length = 1000)
    var authorizationGrantTypes: String? =null

    @Column(name="redirect_uris", length = 1000)
    var redirectUris: String? =null

    @Column(name="post_logout_redirect_uris", length = 1000)
    var postLogoutRedirectUris: String? =null

    @Column(length = 1000)
    var scopes: String? =null

    @Column(name="client_settings", length = 2000)
    var clientSettings: String? =null


    @Column(name="token_settings", length = 2000)
    var tokenSettings: String? =null
}
