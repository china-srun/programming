import 'package:book_tracker/theme_changer.dart';
import 'package:flutter/material.dart';

import '../controller/book_controller.dart';
import '../models/Book.dart';
import '../repository/book_repository.dart';

class ProfilePage extends StatefulWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  State<ProfilePage> createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  var bookController = BookController(BookRepository());
  var allBooks = 0;
  var completedBooks = 0;
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    return Stack(
      fit: StackFit.expand,
      children: [
        Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.transparent,
            title: const Text(
              "Profile",
              style: TextStyle(
                fontSize: 25,
                color: Colors.black,
              ),
            ),
            elevation: 0,
            actions: [
              Padding(
                padding: const EdgeInsets.only(right: 8.0),
                child: InkWell(
                  child: const Icon(Icons.mode_night_outlined,
                      color: Colors.black),
                  onTap: () {
                    ThemeBuilder.of(context)!.changedTheme();
                  },
                ),
              )
            ],
          ),
          body: SingleChildScrollView(
            physics: const BouncingScrollPhysics(),
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 30),
              child: Column(
                children: [
                  SizedBox(
                    height: height * 0.43,
                    child: LayoutBuilder(
                      builder: (context, constraints) {
                        double innerHeight = constraints.maxHeight;
                        double innerWidth = constraints.maxWidth;
                        return Stack(
                          fit: StackFit.expand,
                          children: [
                            Positioned(
                              bottom: 0,
                              left: 0,
                              right: 0,
                              child: Container(
                                height: innerHeight * 0.72,
                                width: innerWidth,
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(30),
                                  color: Colors.white,
                                ),
                                child: Column(
                                  children: [
                                    const SizedBox(
                                      height: 80,
                                    ),
                                    const Padding(
                                      padding: EdgeInsets.only(top: 8.0),
                                      child: Text(
                                        'China Srun',
                                        style: TextStyle(
                                          color:
                                              Color.fromRGBO(39, 105, 171, 1),
                                          fontFamily: 'Nunito',
                                          fontSize: 30,
                                        ),
                                      ),
                                    ),
                                    const SizedBox(
                                      height: 5,
                                    ),
                                    Row(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        Column(
                                          children: [
                                            Text(
                                              'All Books',
                                              style: TextStyle(
                                                color: Colors.grey[700],
                                                fontFamily: 'Nunito',
                                                fontSize: 25,
                                              ),
                                            ),
                                            Text(
                                              '$completedBooks',
                                              style: const TextStyle(
                                                color: Color.fromRGBO(
                                                    39, 105, 171, 1),
                                                fontFamily: 'Nunito',
                                                fontSize: 25,
                                              ),
                                            ),
                                          ],
                                        ),
                                        Padding(
                                          padding: const EdgeInsets.symmetric(
                                            horizontal: 25,
                                            vertical: 8,
                                          ),
                                          child: Container(
                                            height: 50,
                                            width: 3,
                                            decoration: BoxDecoration(
                                              borderRadius:
                                                  BorderRadius.circular(100),
                                              color: Colors.grey,
                                            ),
                                          ),
                                        ),
                                        Column(
                                          children: [
                                            Text(
                                              'Completed',
                                              style: TextStyle(
                                                color: Colors.grey[700],
                                                fontFamily: 'Nunito',
                                                fontSize: 25,
                                              ),
                                            ),
                                            Text(
                                              '$allBooks',
                                              style: const TextStyle(
                                                color: Color.fromRGBO(
                                                    39, 105, 171, 1),
                                                fontFamily: 'Nunito',
                                                fontSize: 25,
                                              ),
                                            ),
                                          ],
                                        ),
                                      ],
                                    )
                                  ],
                                ),
                              ),
                            ),
                            Positioned(
                              top: 0,
                              left: 0,
                              right: 0,
                              child: Center(
                                child: Image.network(
                                  'https://www.eclipsegroup.co.uk/wp-content/uploads/2020/03/Round-Profile-Picture-768x768-1.png',
                                  width: innerWidth * 0.45,
                                  fit: BoxFit.fitWidth,
                                ),
                              ),
                            ),
                          ],
                        );
                      },
                    ),
                  ),
                  const SizedBox(
                    height: 30,
                  ),
                  Container(
                    width: width,
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(30),
                      color: Colors.white,
                    ),
                    child: Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 15),
                      child: Column(
                        children: [
                          const SizedBox(
                            height: 20,
                          ),
                          const Text(
                            'Completed Books',
                            style: TextStyle(
                              color: Color.fromRGBO(39, 105, 171, 1),
                              fontSize: 27,
                              fontFamily: 'Nunito',
                            ),
                          ),
                          const Divider(
                            thickness: 2.5,
                          ),
                          const SizedBox(
                            height: 10,
                          ),
                          FutureBuilder<List<Book>>(
                            future: bookController.fetchBooks(),
                            builder: ((context, snapshot) {
                              allBooks = snapshot.data?.length ?? 0;
                              return ListView.separated(
                                  scrollDirection: Axis.vertical,
                                  shrinkWrap: true,
                                  itemBuilder: (context, index) {
                                    var book = snapshot.data?[index];

                                    if (book!.completed == "Yes") {
                                      completedBooks += 1;
                                      return Padding(
                                        padding: const EdgeInsets.symmetric(
                                          vertical: 20,
                                          horizontal: 10,
                                        ),
                                        child: Row(
                                          children: [
                                            Expanded(
                                                flex: 2,
                                                child: Text(
                                                  '${book.id}',
                                                  style: const TextStyle(
                                                    color: Color.fromRGBO(
                                                        39, 105, 171, 1),
                                                  ),
                                                )),
                                            Expanded(
                                              flex: 4,
                                              child: Text(
                                                '${book.title}',
                                                style: const TextStyle(
                                                  color: Color.fromRGBO(
                                                      39, 105, 171, 1),
                                                ),
                                              ),
                                            ),
                                          ],
                                        ),
                                      );
                                    } else {
                                      return const SizedBox();
                                    }
                                  },
                                  separatorBuilder: (context, index) {
                                    return const Divider(
                                      thickness: 0.5,
                                      height: 0.5,
                                    );
                                  },
                                  itemCount: snapshot.data?.length ?? 0);
                            }),
                          ),
                        ],
                      ),
                    ),
                  )
                ],
              ),
            ),
          ),
        )
      ],
    );
  }
}
