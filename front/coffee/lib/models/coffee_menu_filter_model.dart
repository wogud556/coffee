class CoffeeMenuFIlterModel {
  final String menuFilter, menuFilterEn, image;
// {id: 774862, title: 조조코믹스, thumb: https://image-comic.pstatic.net/webtoon/774862/thumbnail/thumbnail_IMAG21_39b7c327-7234-4636-b608-401478abede3.jpg}
  CoffeeMenuFIlterModel.fromJson(Map<String, dynamic> json)
      : menuFilter = json['menu_filter'],
        menuFilterEn = json['menu_filter_en'],
        image = json['image'];
}
