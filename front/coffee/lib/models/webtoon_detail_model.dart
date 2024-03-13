class WebtoonDetailModel {
  final String title, about, genre, age;
// {id: 774862, title: 조조코믹스, thumb: https://image-comic.pstatic.net/webtoon/774862/thumbnail/thumbnail_IMAG21_39b7c327-7234-4636-b608-401478abede3.jpg}
  WebtoonDetailModel.fromJson(Map<String, dynamic> json)
      : title = json['title'],
        about = json['about'],
        genre = json['genre'],
        age = json['age'];
}
