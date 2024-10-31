package com.baims.dailyforecast.data.remote.model


import com.google.gson.annotations.SerializedName

/**
{"cod":"200","message":0,"cnt":40,"list":[{"dt":1730376000,"main":{"temp":297.48,"feels_like":297.09,"temp_min":297.48,"temp_max":299.08,"pressure":1011,"sea_level":1011,"grnd_level":1005,"humidity":43,"temp_kf":-1.6},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":75},"wind":{"speed":1.96,"deg":333,"gust":4.13},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-10-31 12:00:00"},{"dt":1730386800,"main":{"temp":298.1,"feels_like":297.62,"temp_min":298.1,"temp_max":299.35,"pressure":1011,"sea_level":1011,"grnd_level":1005,"humidity":37,"temp_kf":-1.25},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":51},"wind":{"speed":3.12,"deg":355,"gust":4.89},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-10-31 15:00:00"},{"dt":1730397600,"main":{"temp":296.28,"feels_like":295.82,"temp_min":295.68,"temp_max":296.28,"pressure":1012,"sea_level":1012,"grnd_level":1007,"humidity":45,"temp_kf":0.6},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":39},"wind":{"speed":6.85,"deg":9,"gust":9.39},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-10-31 18:00:00"},{"dt":1730408400,"main":{"temp":294.03,"feels_like":293.56,"temp_min":294.03,"temp_max":294.03,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":53,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":3.4,"deg":350,"gust":5.27},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-10-31 21:00:00"},{"dt":1730419200,"main":{"temp":292.82,"feels_like":292.38,"temp_min":292.82,"temp_max":292.82,"pressure":1013,"sea_level":1013,"grnd_level":1007,"humidity":59,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":2.81,"deg":320,"gust":3.92},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-01 00:00:00"},{"dt":1730430000,"main":{"temp":291.92,"feels_like":291.55,"temp_min":291.92,"temp_max":291.92,"pressure":1013,"sea_level":1013,"grnd_level":1007,"humidity":65,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":7},"wind":{"speed":2.65,"deg":324,"gust":3.79},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-01 03:00:00"},{"dt":1730440800,"main":{"temp":293,"feels_like":292.74,"temp_min":293,"temp_max":293,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":65,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":5},"wind":{"speed":2.19,"deg":320,"gust":3.17},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-01 06:00:00"},{"dt":1730451600,"main":{"temp":296.71,"feels_like":296.37,"temp_min":296.71,"temp_max":296.71,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":48,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":2.4,"deg":324,"gust":3.61},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-01 09:00:00"},{"dt":1730462400,"main":{"temp":299.92,"feels_like":299.55,"temp_min":299.92,"temp_max":299.92,"pressure":1012,"sea_level":1012,"grnd_level":1006,"humidity":33,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":6},"wind":{"speed":3.29,"deg":284,"gust":4.14},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-01 12:00:00"},{"dt":1730473200,"main":{"temp":298.77,"feels_like":298.33,"temp_min":298.77,"temp_max":298.77,"pressure":1012,"sea_level":1012,"grnd_level":1006,"humidity":36,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":99},"wind":{"speed":6.7,"deg":301,"gust":7.03},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-01 15:00:00"},{"dt":1730484000,"main":{"temp":296.42,"feels_like":295.98,"temp_min":296.42,"temp_max":296.42,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":45,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":92},"wind":{"speed":6.67,"deg":348,"gust":8.34},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-01 18:00:00"},{"dt":1730494800,"main":{"temp":294.46,"feels_like":294.08,"temp_min":294.46,"temp_max":294.46,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":55,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":93},"wind":{"speed":4.25,"deg":338,"gust":5.55},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-01 21:00:00"},{"dt":1730505600,"main":{"temp":293.37,"feels_like":292.96,"temp_min":293.37,"temp_max":293.37,"pressure":1013,"sea_level":1013,"grnd_level":1007,"humidity":58,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":88},"wind":{"speed":2.28,"deg":325,"gust":2.7},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-02 00:00:00"},{"dt":1730516400,"main":{"temp":292.47,"feels_like":292.18,"temp_min":292.47,"temp_max":292.47,"pressure":1013,"sea_level":1013,"grnd_level":1007,"humidity":66,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":86},"wind":{"speed":1.69,"deg":273,"gust":1.94},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-02 03:00:00"},{"dt":1730527200,"main":{"temp":293.26,"feels_like":292.92,"temp_min":293.26,"temp_max":293.26,"pressure":1015,"sea_level":1015,"grnd_level":1008,"humidity":61,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":66},"wind":{"speed":2.91,"deg":238,"gust":3.55},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-02 06:00:00"},{"dt":1730538000,"main":{"temp":297.5,"feels_like":297.03,"temp_min":297.5,"temp_max":297.5,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":40,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":5},"wind":{"speed":4.84,"deg":233,"gust":5.82},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-02 09:00:00"},{"dt":1730548800,"main":{"temp":299.64,"feels_like":299.64,"temp_min":299.64,"temp_max":299.64,"pressure":1012,"sea_level":1012,"grnd_level":1006,"humidity":30,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":3},"wind":{"speed":5.91,"deg":253,"gust":6.62},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-02 12:00:00"},{"dt":1730559600,"main":{"temp":298.58,"feels_like":297.94,"temp_min":298.58,"temp_max":298.58,"pressure":1012,"sea_level":1012,"grnd_level":1006,"humidity":29,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":2},"wind":{"speed":4.95,"deg":276,"gust":5.31},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-02 15:00:00"},{"dt":1730570400,"main":{"temp":296.36,"feels_like":295.62,"temp_min":296.36,"temp_max":296.36,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":34,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":2},"wind":{"speed":4.03,"deg":275,"gust":6.17},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-02 18:00:00"},{"dt":1730581200,"main":{"temp":294.57,"feels_like":293.84,"temp_min":294.57,"temp_max":294.57,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":41,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":7},"wind":{"speed":2.37,"deg":278,"gust":3.36},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-02 21:00:00"},{"dt":1730592000,"main":{"temp":294.08,"feels_like":293.51,"temp_min":294.08,"temp_max":294.08,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":49,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":31},"wind":{"speed":1.78,"deg":238,"gust":3.08},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-03 00:00:00"},{"dt":1730602800,"main":{"temp":292.71,"feels_like":292.13,"temp_min":292.71,"temp_max":292.71,"pressure":1015,"sea_level":1015,"grnd_level":1008,"humidity":54,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":5},"wind":{"speed":2.4,"deg":220,"gust":3.49},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-03 03:00:00"},{"dt":1730613600,"main":{"temp":293.3,"feels_like":292.78,"temp_min":293.3,"temp_max":293.3,"pressure":1016,"sea_level":1016,"grnd_level":1009,"humidity":54,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":5},"wind":{"speed":2.78,"deg":205,"gust":3.64},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-03 06:00:00"},{"dt":1730624400,"main":{"temp":296.98,"feels_like":296.54,"temp_min":296.98,"temp_max":296.98,"pressure":1015,"sea_level":1015,"grnd_level":1009,"humidity":43,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":4},"wind":{"speed":4.52,"deg":213,"gust":5.95},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-03 09:00:00"},{"dt":1730635200,"main":{"temp":299.1,"feels_like":299.1,"temp_min":299.1,"temp_max":299.1,"pressure":1013,"sea_level":1013,"grnd_level":1007,"humidity":35,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":9},"wind":{"speed":4.19,"deg":254,"gust":4.34},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-03 12:00:00"},{"dt":1730646000,"main":{"temp":298.71,"feels_like":298.21,"temp_min":298.71,"temp_max":298.71,"pressure":1014,"sea_level":1014,"grnd_level":1008,"humidity":34,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],"clouds":{"all":45},"wind":{"speed":4.65,"deg":292,"gust":4.7},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-03 15:00:00"},{"dt":1730656800,"main":{"temp":296.03,"feels_like":295.68,"temp_min":296.03,"temp_max":296.03,"pressure":1016,"sea_level":1016,"grnd_level":1010,"humidity":50,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":60},"wind":{"speed":6.01,"deg":352,"gust":7.74},"visibility":10000,"pop":0.22,"rain":{"3h":0.1},"sys":{"pod":"n"},"dt_txt":"2024-11-03 18:00:00"},{"dt":1730667600,"main":{"temp":293.91,"feels_like":293.69,"temp_min":293.91,"temp_max":293.91,"pressure":1016,"sea_level":1016,"grnd_level":1010,"humidity":63,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":49},"wind":{"speed":3.68,"deg":338,"gust":5.76},"visibility":10000,"pop":0.31,"rain":{"3h":0.12},"sys":{"pod":"n"},"dt_txt":"2024-11-03 21:00:00"},{"dt":1730678400,"main":{"temp":292.53,"feels_like":292.4,"temp_min":292.53,"temp_max":292.53,"pressure":1016,"sea_level":1016,"grnd_level":1010,"humidity":72,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":24},"wind":{"speed":3.08,"deg":339,"gust":4.57},"visibility":10000,"pop":0.25,"rain":{"3h":0.1},"sys":{"pod":"n"},"dt_txt":"2024-11-04 00:00:00"},{"dt":1730689200,"main":{"temp":291.65,"feels_like":291.57,"temp_min":291.65,"temp_max":291.65,"pressure":1017,"sea_level":1017,"grnd_level":1011,"humidity":77,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":2.75,"deg":332,"gust":4.37},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-04 03:00:00"},{"dt":1730700000,"main":{"temp":293.07,"feels_like":292.92,"temp_min":293.07,"temp_max":293.07,"pressure":1018,"sea_level":1018,"grnd_level":1012,"humidity":69,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":2.28,"deg":344,"gust":3.95},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-04 06:00:00"},{"dt":1730710800,"main":{"temp":297.11,"feels_like":296.79,"temp_min":297.11,"temp_max":297.11,"pressure":1018,"sea_level":1018,"grnd_level":1012,"humidity":47,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":2.89,"deg":328,"gust":3.8},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-04 09:00:00"},{"dt":1730721600,"main":{"temp":299.61,"feels_like":299.61,"temp_min":299.61,"temp_max":299.61,"pressure":1016,"sea_level":1016,"grnd_level":1010,"humidity":35,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":3.89,"deg":291,"gust":4.06},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-04 12:00:00"},{"dt":1730732400,"main":{"temp":298.71,"feels_like":298.18,"temp_min":298.71,"temp_max":298.71,"pressure":1016,"sea_level":1016,"grnd_level":1010,"humidity":33,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],"clouds":{"all":31},"wind":{"speed":5.77,"deg":302,"gust":5.42},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-04 15:00:00"},{"dt":1730743200,"main":{"temp":296.05,"feels_like":295.49,"temp_min":296.05,"temp_max":296.05,"pressure":1017,"sea_level":1017,"grnd_level":1011,"humidity":42,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02n"}],"clouds":{"all":15},"wind":{"speed":4.67,"deg":354,"gust":6.6},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-04 18:00:00"},{"dt":1730754000,"main":{"temp":293.98,"feels_like":293.71,"temp_min":293.98,"temp_max":293.98,"pressure":1018,"sea_level":1018,"grnd_level":1012,"humidity":61,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":3.36,"deg":24,"gust":4.31},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-04 21:00:00"},{"dt":1730764800,"main":{"temp":293.07,"feels_like":292.84,"temp_min":293.07,"temp_max":293.07,"pressure":1017,"sea_level":1017,"grnd_level":1011,"humidity":66,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":1.89,"deg":15,"gust":2.25},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-05 00:00:00"},{"dt":1730775600,"main":{"temp":291.98,"feels_like":291.77,"temp_min":291.98,"temp_max":291.98,"pressure":1017,"sea_level":1017,"grnd_level":1011,"humidity":71,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":1.94,"deg":351,"gust":2.16},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-11-05 03:00:00"},{"dt":1730786400,"main":{"temp":292.69,"feels_like":292.48,"temp_min":292.69,"temp_max":292.69,"pressure":1018,"sea_level":1018,"grnd_level":1012,"humidity":68,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":1.06,"deg":1,"gust":0.9},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-05 06:00:00"},{"dt":1730797200,"main":{"temp":295.31,"feels_like":294.94,"temp_min":295.31,"temp_max":295.31,"pressure":1018,"sea_level":1018,"grnd_level":1011,"humidity":52,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":1.99,"deg":323,"gust":1.96},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-11-05 09:00:00"}],"city":{"id":7922173,"name":"Al ‘Atabah","coord":{"lat":30.0444,"lon":31.2357},"country":"EG","population":0,"timezone":10800,"sunrise":1730347698,"sunset":1730387333}}
*/
data class Item8(
    @SerializedName("clouds")
    val clouds: Clouds?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("dt_txt")
    val dtTxt: String?,
    @SerializedName("main")
    val main: Main?,
    @SerializedName("pop")
    val pop: Double?,
    @SerializedName("rain")
    val rain: Rain?,
    @SerializedName("sys")
    val sys: Sys?,
    @SerializedName("visibility")
    val visibility: Int?,
    @SerializedName("weather")
    val weather: List<Weather?>?,
    @SerializedName("wind")
    val wind: Wind?
)