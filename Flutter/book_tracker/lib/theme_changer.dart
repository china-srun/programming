import 'package:flutter/material.dart';

class ThemeBuilder extends StatefulWidget {
  final Widget Function(BuildContext context, Brightness brightness) builder;

  ThemeBuilder({required this.builder});

  @override
  State<ThemeBuilder> createState() => _ThemeBuilderState();

  static _ThemeBuilderState? of(BuildContext context) {
    return context.findAncestorStateOfType<_ThemeBuilderState>();
  }
}

class _ThemeBuilderState extends State<ThemeBuilder> {
  Brightness _brightness = Brightness.light;
  @override
  void initState() {
    _brightness = Brightness.light;
    super.initState();
  }

  void changedTheme() {
    setState(() {
      _brightness =
          _brightness == Brightness.dark ? Brightness.light : Brightness.dark;
    });
  }

  @override
  Widget build(BuildContext context) {
    return widget.builder(context, _brightness);
  }
}
