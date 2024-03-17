import 'package:flutter/material.dart';
import 'package:toonflix/models/coffee_menu_filter_model.dart';
import 'package:toonflix/services/api_service.dart';
import 'package:toonflix/widgets/filter_widget.dart';

class HomeScreen extends StatelessWidget {
  HomeScreen({super.key});

  // 얘가 선언된 순간부터 이 클래스는  const일 수 없다.
  final Future<List<CoffeeMenuFilterModel>> filter = ApiService.getMenuFilter();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        elevation: 2,
        backgroundColor: Colors.white,
        foregroundColor: Colors.brown,
        title: const Text(
          "커피 메뉴",
          style: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: FutureBuilder(
        future: filter,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return Column(
              children: [
                const SizedBox(
                  height: 30,
                ),
                Expanded(child: makeList(snapshot))
              ],
            );
          }
          return const Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
    );
  }

  ListView makeList(AsyncSnapshot<List<CoffeeMenuFilterModel>> snapshot) {
    return ListView.separated(
      scrollDirection: Axis.vertical,
      itemCount: snapshot.data!.length,
      itemBuilder: (context, index) {
        var filter = snapshot.data![index];
        return MenuFilter(
          menuFilter: filter.menuFilter,
          menuFilterEn: filter.menuFilterEn,
          image: filter.image,
        );
      },
      separatorBuilder: (context, index) => const SizedBox(
        width: 40,
      ),
    );
  }
}
