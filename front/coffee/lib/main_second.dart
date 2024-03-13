import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import '/widgets/button.dart';
import '/widgets/card.dart';

const taxAmount = 15;
const priceAmount = 30;

var finalPrice = taxAmount + priceAmount;

class Player {
  String? name; //갖거나 가지지 않을 수도 있다.

  Player({required this.name});
}

void main() {
  var nico = Player(name: "potato");
  //runApp은 리턴이 없는 함수
  //위젯을 합치는 방식으로 화면을 만들어 내는 방식
  //앱 생성의 시작부분이다.
  runApp(const App());
}

class App extends StatefulWidget {
  const App({super.key});

  @override
  State<App> createState() => _AppState();
}

class _AppState extends State<App> {
  //statelessWidget은 widget을 상속받으므로 build를 구현해야함
  List<int> numbers = [];

  void onClicked() {
    setState(() {
      numbers.add(numbers.length);
    });
  }

  void onClicked2() {
    setState(() {
      numbers.removeLast();
    });
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    //머터리얼이나 쿠퍼티노를 리턴해줌
    return MaterialApp(
      home: Scaffold(
        backgroundColor: const Color(0xFFF4EDDB),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const MyLargeTitle(),
              for (var n in numbers) Text('$n'),
              IconButton(
                iconSize: 40,
                onPressed: onClicked,
                icon: const Icon(
                  Icons.add_box_rounded,
                ),
              ),
              IconButton(
                iconSize: 40,
                onPressed: onClicked2,
                icon: const Icon(
                  Icons.delete,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class MyLargeTitle extends StatelessWidget {
  const MyLargeTitle({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return const Text(
      'My Large Title',
      style: TextStyle(fontSize: 30),
    );
  }
}
