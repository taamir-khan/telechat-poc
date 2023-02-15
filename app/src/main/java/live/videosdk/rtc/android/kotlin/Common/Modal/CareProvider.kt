package live.videosdk.rtc.android.kotlin.Common.Modal

class CareProvider(var titleImage: Int, var heading : String, var description : String, var visibility : Boolean = false) {
    var e_titleImage: Int
    var e_heading: String
    var e_description: String
    var e_visibility: Boolean

    init {
        e_titleImage = titleImage
        e_heading = heading
        e_description = description
        e_visibility = visibility
    }
}