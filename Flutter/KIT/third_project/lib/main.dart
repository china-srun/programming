import 'package:flutter/material.dart';

void main() {
  runApp(
    const MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Third Project",
      home: MyScaffold(),
    ),
  );
}

class MyScaffold extends StatelessWidget {
  const MyScaffold({super.key});

  @override
  Widget build(BuildContext context) {
    return Material(
      child: Column(
        children: const [
          MyAppBar(title: "Cool App"),
          Text("Demo for KIT on myOwn appBar")
        ],
      ),
    );
  }
}

class MyAppBar extends StatelessWidget {
  const MyAppBar({super.key, required this.title});

  final String title;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 50.0,
      decoration: const BoxDecoration(color: Colors.pink),
      child: Row(
        children: [
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.home),
          ),
          Expanded(
            child: Text(
              title,
              style: const TextStyle(
                  color: Colors.white, fontWeight: FontWeight.bold),
            ),
          ),
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.search),
          ),
        ],
      ),
    );
  }
}
