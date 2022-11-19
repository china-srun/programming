import 'package:flutter/material.dart';

class testubg_screen extends StatefulWidget {
  testubg_screen({Key? key}) : super(key: key);

  @override
  State<testubg_screen> createState() => _testubg_screenState();
}

class _testubg_screenState extends State<testubg_screen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Helllo world"))
    );
  }
}
