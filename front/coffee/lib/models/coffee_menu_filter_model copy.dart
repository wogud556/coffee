class MenuFilterDetailModel {
  final String menuId, menuName, menuNameEn, image, price;
// {id: 774862, title: 조조코믹스, thumb: https://image-comic.pstatic.net/webtoon/774862/thumbnail/thumbnail_IMAG21_39b7c327-7234-4636-b608-401478abede3.jpg}
  MenuFilterDetailModel.fromJson(Map<String, dynamic> json)
      : menuId = json['menu_id'],
        menuName = json['menu_name'],
        menuNameEn = json['menu_name_en'],
        image = json['image'],
        price = json['price'];
}
