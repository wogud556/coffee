import 'package:flutter/material.dart';
import '/screens/detail_screen.dart';

class MenuFilter extends StatelessWidget {
  final String menuFilter, menuFilterEn, image;

  const MenuFilter({
    super.key,
    required this.menuFilter,
    required this.menuFilterEn,
    required this.image,
  });

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {},
      child: Column(
        children: [
          Hero(
            //태그를 항상 갖고 있어야 됨
            tag: menuFilterEn,
            child: Card(
              child: Padding(
                padding:
                    const EdgeInsets.symmetric(horizontal: 20, vertical: 16),
                child: Row(
                  children: [
                    Image.network(
                      image,
                      width: 75,
                    ),
                    const SizedBox(
                      width: 20,
                    ),
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          menuFilter,
                          style: const TextStyle(
                            fontSize: 20,
                          ),
                        ),
                        Text(
                          menuFilterEn,
                          style: const TextStyle(
                            fontSize: 11,
                            color: Colors.grey,
                          ),
                        ),
                      ],
                    )
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
