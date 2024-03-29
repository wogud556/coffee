import 'dart:convert';

import 'package:http/http.dart' as http;
import '../models/coffee_menu_filter_model copy.dart';
import '/models/coffee_menu_filter_model.dart';
import '/models/webtoon.dart';
import '/models/webtoon_detail_model.dart';
import '/models/webtoon_episode_model.dart';

class ApiService {
  static const String baseUrl =
      "https://webtoon-crawler.nomadcoders.workers.dev";
  static const String menuUrl = "";
  static const String today = "today";

  //pub.dev로 가면 dart의 패키지를 확인할 수 있다.
  static Future<List<WebtoonModel>> getTodaysToons() async {
    //비동기로 따로 처리하게끔 만든다.
    List<WebtoonModel> webtoonInstances = [];
    final url = Uri.parse('$baseUrl/$today');
    final response =
        await http.get(url); // 미래에 받을 값을 미리 정해놓음 보통 http 패키지에서 많이 사용됨
    if (response.statusCode == 200) {
      final List<dynamic> webtoons = jsonDecode(response.body);
      for (var webtoon in webtoons) {
        webtoonInstances.add(WebtoonModel.fromJson(webtoon));
      }
      return webtoonInstances;
    }
    throw Error();
  }

  static Future<WebtoonDetailModel> getToonById(String id) async {
    final url = Uri.parse("$baseUrl/$id");
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final webtoon = jsonDecode(response.body);
      return WebtoonDetailModel.fromJson(webtoon);
    }
    throw Error();
  }

  static Future<List<WebtoonEpisodeModel>> getLatestEpisodesById(
      String id) async {
    List<WebtoonEpisodeModel> episodesInstances = [];
    final url = Uri.parse("$baseUrl/$id/episodes");
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final episodes = jsonDecode(response.body);
      for (var episode in episodes) {
        episodesInstances.add(WebtoonEpisodeModel.fromJson(episode));
      }
      return episodesInstances;
    }
    throw Error();
  }

  static Future<List<CoffeeMenuFilterModel>> getMenuFilter() async {
    List<CoffeeMenuFilterModel> menuFilterInstance = [];
    final url = Uri.parse(menuUrl);
    final response = await http.post(url);
    print(response.statusCode);
    if (response.statusCode == 200) {
      final filters = jsonDecode(utf8.decode(response.bodyBytes));

      for (var filter in filters) {
        menuFilterInstance.add(CoffeeMenuFilterModel.fromJson(filter));
        print(CoffeeMenuFilterModel.fromJson(filter).menuFilter);
      }
      return menuFilterInstance;
    }
    throw Error();
  }

  static Future<List<MenuFilterDetailModel>> getMenuFilterDetail(
      String filterEn, String coffeeDivCd) async {
    List<MenuFilterDetailModel> menuFilterInstance = [];
    final url = Uri.parse(menuUrl);
    Map data = {"coffeeDivCd": coffeeDivCd, "filter": filterEn};
    var body = json.encode(data);
    final response = await http.post(
      url,
      headers: {"Content-Type": "application/json"},
      body: body,
    );
    print(response.statusCode);
    if (response.statusCode == 200) {
      final menudetails = jsonDecode(utf8.decode(response.bodyBytes));

      for (var menudetail in menudetails) {
        menuFilterInstance.add(MenuFilterDetailModel.fromJson(menudetail));
        print(CoffeeMenuFilterModel.fromJson(menudetail).menuFilter);
      }
      return menuFilterInstance;
    }
    throw Error();
  }
}
