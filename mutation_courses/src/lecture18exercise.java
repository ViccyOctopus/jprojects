import tester.Tester;

class Course {
  String departmentName;
  int courseNum;
  Instructor instructor;
  IList<Student> students;

  Course(String departmentName, int courseNum, Instructor instructor, IList<Student> students) {
    this.departmentName = departmentName;
    this.courseNum = courseNum;
    this.instructor = instructor;
    // This allows you to have no students
    // in a given course yet
    this.students = new Mt<Student>();
  }
}

class Student {
  String first;
  String last;
  IList<Course> coursesEnrolled;

  Student(String first, String last, IList<Course> coursesEnrolled) {
    this.first = first;
    this.last = last;
    // This allows you to have students that have
    // not yet enrolled in any classes
    this.coursesEnrolled = new Mt<Course>();
  }

}

class Instructor {
  String first;
  String last;
  IList<Course> coursesAssigned;

  Instructor(String first, String last, IList<Course> coursesAssigned) {
    this.first = first;
    this.last = last;
    // This allows you to have instructors
    // that have not yet been assigned to course(s)
    this.coursesAssigned = new Mt<Course>();
  }
}

interface IList<T> {

}

class Mt<T> implements  IList<T> {

}

class Cons<T>implements  IList<T> {
  T first;
  IList<T> rest;

  Cons(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }
}

class Examples {
  // Construct examples of at least three courses,
  // at least two professors,
  // and at least four students
  Course discrete, algo, fundies;
  Instructor benLerner, virgil;
  Student victoria, aiyan, liv;

  void initTestConditions() {
    this.benLerner = new Instructor("Ben", "Lerner",
      new Cons<Course>(this.fundies,
        new Mt<Course>()));
    this.virgil = new Instructor("Ben", "Lerner",
      new Cons<Course>(this.discrete,
        new Cons<Course>(this.algo,
          new Mt<Course>())));

    this.victoria = new Student("Victoria", "Arzumanova",
      new Cons<Course>(this.fundies,
        new Mt<Course>()));
    this.aiyan = new Student("Aiyan", "Jiang",
      new Cons<Course>(this.fundies,
        new Cons<Course>(this.algo,
          new Mt<Course>())));
    this.liv = new Student("Liv", "Mintz",
      new Cons<Course>(this.fundies,
        new Cons<Course>(this.discrete,
          new Mt<Course>())));


    IList<Student> group1 = new Cons<Student>(victoria,
      new Cons<Student>(aiyan,
        new Cons<Student>(liv,
          new Mt<Student>())));
    IList<Student> group2 = new Cons<Student>(aiyan,
      new Mt<Student>());
    IList<Student> group3 = new Cons<Student>(liv,
      new Mt<Student>());

    this.fundies = new Course("Khoury", 2510, benLerner, group1);
    this.discrete = new Course("Khoury", 2800, virgil, group3);
    this.algo = new Course("Khoury", 3200, virgil, group2);
  }

}