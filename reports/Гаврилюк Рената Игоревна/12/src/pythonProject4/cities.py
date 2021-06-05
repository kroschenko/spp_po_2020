import csv
import random


class Cities:
    def __init__(self):
        self.__existing_cities = get_existing_cities("city.csv")
        self.__named_cities = []
        self.__last_named_city = self.generate_first_city()
        print(self.__last_named_city)

    def generate_first_city(self):
        """Генерирует рандомный первый город дляачала игры"""
        first_city = random.choice(self.__existing_cities)
        self.__last_named_city = first_city
        self.__named_cities.append(first_city)
        return first_city

    def city_exists(self, city_name):
        """"Проверяет существует ли такой город"""
        for city in self.__existing_cities:
            if city.lower() == city_name.lower():
                return True
        return False

    def city_was_named(self, city_name):
        """"Проверяет был ли упомняут ранее такой город"""
        for city in self.__named_cities:
            if city.lower() == city_name.lower():
                return True
        return False

    def check_conditions(self, city_name):
        """"Проверяет удовлетворяет ли требованиям имени города"""
        if city_name[0].lower() == self.__last_named_city[-1:]:
            return True
        if self.__last_named_city[-1:] == 'ъ' or self.__last_named_city[-1:] == 'ь':
            if city_name[0].lower() == self.__last_named_city[-2:-1]:
                return True
        return False

    def add_city_to_named(self, city_name):
        """
        Добавляет город в список названных, если он удоавлетворяет условиям
        :return
        0 - успешное добавление
        -1 - город не удовлетворяет требованиям
        """
        if self.city_exists(city_name):
            if self.check_conditions(city_name):
                if not self.city_was_named(city_name):
                    self.__last_named_city = city_name
                    self.__named_cities.append(city_name)
                    return 0
        return -1

    def get_last_named_city(self):
        return self.__last_named_city

    def restart(self):
        self.__named_cities = []
        self.__last_named_city = self.generate_first_city()


def get_existing_cities(csv_path):
    """Возвращает список существующих городов России"""
    file_obj = open(csv_path, "r")
    cities = []
    reader = csv.DictReader(file_obj, delimiter=';')
    for line in reader:
        cities.append(line['name'])
    return cities
