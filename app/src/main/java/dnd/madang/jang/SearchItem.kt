package dnd.madang.jang


class BaseResponse(var code : Int, var result : ResultResponse)
class ResultResponse(var products : ArrayList<SearchItem>)
class SearchItem (val mch_prd_name: String, val cate_name: String,val mch_prd_cate: String)
class AccountBaseResponse(var code : String, var result : AccountResultResponse)
class AccountResultResponse(var isLoggedin : Boolean)