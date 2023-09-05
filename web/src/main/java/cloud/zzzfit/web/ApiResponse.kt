package cloud.zzzfit.web

class ApiResponse<T> {
    var success: Boolean = true
    var message: String? = null
    var code: Int? = null
    var result: T? = null
//    private ErrorCode errorCode;
}
