import 'package:flutter/material.dart';

void main() {
  runApp(
    const MaterialApp(
      title: "Flutter Stateless Project",
      home: MyApp(),
      debugShowCheckedModeBanner: false,
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("First Flutter App"),
        ),
        body: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: const [
              Bycicle("Adidas", 3, "assets/pic1.jpg"),
              Bycicle("Nike", 3, "assets/pic1.jpg"),
              Bycicle("Adidas", 3, "assets/pic1.jpg"),
              Bycicle("Adidas", 3, "assets/pic1.jpg"),
            ],
          ),
        ));
  }
}

class Bycicle extends StatelessWidget {
  const Bycicle(this.brand, this.rate, this.img, {super.key});

  final String brand;
  final int rate;
  final String img;
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Text(brand),
        ),
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Text(rate.toString()),
        ),
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Image.asset(img, width: 200),
        )
      ],
    );
  }
}
