package com.jay.backend.order.service

import com.jay.backend.order.dto.response.FilterNmResponse
import com.jay.backend.order.dto.response.MenuDetailResponse
import com.jay.backend.order.dto.response.ProdcutMenuResponse
import com.jay.backend.order.repository.ProductMenuRepository
import org.springframework.stereotype.Service

@Service
class OrderService (
    private val productMenuRepository : ProductMenuRepository
) {
    companion object {

    }
    fun getMenuByCoffeeDivCd (body : HashMap<String, String>) : List<ProdcutMenuResponse> {

        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCd(body.get("coffeeDivCd"))

        return coffeeMenuAll.map {
            ProdcutMenuResponse(
                menuId = it.menuId,
                menuName = it.menuName,
                menuNameEn = it.menuNameEn,
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                price = it.price,
                image = splitImageRef(it.iceHotDivCd ,it.image)
            )
        }
    }



    fun getMenuByCoffeeDivCdFilterEn (body : HashMap<String, String>) : List<ProdcutMenuResponse> {
        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCdAndMenuFilterEn(body.get("coffeeDivCd"), body.get("filter"))

        return coffeeMenuAll.map {
            ProdcutMenuResponse(
                menuId = it.menuId,
                menuName = it.menuName,
                menuNameEn = it.menuNameEn,
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                price = it.price,
                image = splitImageRef(it.iceHotDivCd ,it.image)
            )
        }
    }

    fun getMenuByCoffeeDetail (body : HashMap<String, String>) : List<ProdcutMenuResponse> {
        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCdAndMenuFilterEn(body.get("coffeeDivCd"), body.get("filter"))

        return coffeeMenuAll.map {
            ProdcutMenuResponse(
                menuId = it.menuId,
                menuName = it.menuName,
                menuNameEn = it.menuNameEn,
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                price = it.price,
                image = splitImageRef(it.iceHotDivCd ,it.image)
            )
        }
    }

    fun getFilterNm() : List<FilterNmResponse> {
        val filterNm = productMenuRepository.findByRole()

        return filterNm.map {
            FilterNmResponse(
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                image = splitImageRef(it.iceHotDivCd, it.image)
            )
        }
    }

    fun getCoffeeDetail (body : HashMap<String, String>) : MenuDetailResponse {
        val coffeeDetail = productMenuRepository.findByCoffeeBrandDivCdAndMenuId(body.get("coffeeDivCd"), body.get("menuId"))

        return MenuDetailResponse(
                menuId = coffeeDetail.menuId,
                menuName = coffeeDetail.menuName,
                menuNameEn = coffeeDetail.menuNameEn,
                enableSize =   splitSizeDvCd(coffeeDetail.enableSize),
                iceHotDivCd =  getListIceHotDivCd(coffeeDetail.iceHotDivCd),
                price = coffeeDetail.price,
                image = makeImageArray(coffeeDetail.image)
            )
    }

    // 주문등록 메소드
    fun registerOrder(body : HashMap<String, String>) : String {

        return ""
    }

    //이미지 경로가 2개 이상 존재하는 상품인 경우
    fun splitImageRef(iceHotDivCd : String, url: String) : String {
        if(iceHotDivCd.length > 1) {
            //무조건 HOT 이미지를 리턴한다.
            return url.split("&")[0]
        }
        else {
            return url
        }
    }

    fun splitSizeDvCd(enableSized : String) : ArrayList<String> {
        var sizeList : ArrayList<String> = ArrayList<String>()
        for(i in enableSized.split("/")) {
            sizeList.add(i)
        }

        return sizeList
    }

    fun makeImageArray(url: String) : ArrayList<String> {
        var imageArray : ArrayList<String> = ArrayList<String>()
        for(i in url.split("&")) {
            imageArray.add(i)
        }

        return imageArray
    }

    fun getListIceHotDivCd(iceHotDivCd : String) : ArrayList<String>{
        var hotAndIce : ArrayList<String> = ArrayList<String>()
        if(!(iceHotDivCd.indexOf("/") == -1)) {
            for(H_I in iceHotDivCd.split("/")) {
                if("H".equals(H_I)) {
                    hotAndIce.add("HOT")
                }else {
                    hotAndIce.add("ICE")
                }
            }
        }else {
            if("H".equals(iceHotDivCd)) {
                hotAndIce.add("HOT")
            }else {
                hotAndIce.add("ICE")
            }
        }
        return hotAndIce
    }

}