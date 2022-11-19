import 'package:flutter/material.dart';

void main() {
  runApp(
    const MaterialApp(title: "Fourth App", home: MyApp()),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 100.0,
      height: 100.0,
      decoration: const BoxDecoration(color: Colors.blue),
      child: const Text(
        "Srun China is handsome boy",
        style: TextStyle(
          color: Colors.red,
        ),
        textAlign: TextAlign.center,
        overflow: TextOverflow.ellipsis,
      ),
    );
  }
}
