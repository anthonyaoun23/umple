# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorAO


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAO Attributes - for documentation purposes
  #attr_reader :name

  #MentorAO Associations - for documentation purposes
  #attr_reader :gradStudent, :students

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_gradStudent)
    @initialized = false
    @deleted = false
    @name = a_name
    @gradStudent = nil
    unless a_gradStudent.nil?
      @gradStudent = a_gradStudent
      a_gradStudent.instance_variable_set("@mentorAO",self)
    end
    @students = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    @name
  end

  def get_gradStudent
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    @gradStudent
  end

  def get_student(index)
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    a_student = @students[index]
    a_student
  end

  def get_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    new_students = @students.dup
    new_students
  end

  def number_of_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    number = @students.size
    number
  end

  def has_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    has = @students.size > 0
    has
  end

  def index_of_student(a_student)
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    index = @students.index(a_student)
    index = -1 if index.nil?
    index
  end

  def is_number_of_students_valid
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    is_valid = number_of_students >= MentorAO.minimum_number_of_students and number_of_students <= MentorAO.maximum_number_of_students
    is_valid
  end

  def self.required_number_of_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    minimum = 2
    minimum
  end

  def self.minimum_number_of_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    minimum = 2
    minimum
  end

  def self.maximum_number_of_students
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    maximum = 2
    maximum
  end

  def add_student(a_student)
    was_added = false
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    return false if index_of_student(a_student) != -1
    if number_of_students >= MentorAO.maximum_number_of_students
      return was_added
    end

    existing_mentor = a_student.get_mentor
    is_new_mentor = (!existing_mentor.nil? and !existing_mentor.eql?(self))

    if is_new_mentor and existing_mentor.number_of_students <= MentorAO.minimum_number_of_students
      return was_added
    end

    if is_new_mentor
      a_student.set_mentor(self)
    else
      @students << a_student
    end
    was_added = true
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    # Unable to remove a_student, as it must always have a mentor
    if a_student.get_mentor.eql?(self)
      return was_removed
    end

    # mentor already at minimum (2)
    if number_of_students <= MentorAO.minimum_number_of_students
      return was_removed
    end

    @students.delete(a_student)
    was_removed = true
    was_removed
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    existing_gradStudent = @gradStudent
    @gradStudent = nil
    unless existing_gradStudent.nil?
      existing_gradStudent.delete
    end
    @students.each do |a_student|
      a_student.delete
    end
  end

end
end