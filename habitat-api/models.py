from google.appengine.ext import ndb
import urllib2

class Base(ndb.Model):
	'''
		Base model - inherited by all other models.
	'''

	created = ndb.DateTimeProperty(auto_now_add = True)
	updated = ndb.DateTimeProperty(auto_now = True)


class Users(Base):
	'''
		Contains some user information.
	'''

	user_id = ndb.StringProperty(required = True)
	cars = ndb.KeyProperty(repeated = True, kind = "Cars")
	alternate_transport = ndb.KeyProperty(repeated = True, kind = "AlternateTransport")
	city = ndb.StringProperty()

	@classmethod
	def save(cls, user_id, car_id, alternate_transport, city, electricity, gas, water):
		'''
			Saves a user entity.
		'''
		car = Cars.save(int(car_id))
		transport_keys = []
		for i in alternate_transport.split(','):
			t = AlternateTransport.query(AlternateTransport.transport_type == i).get()
			transport_keys.append(t.key)
		user = Users()
		user.user_id = user_id
		user.cars = [car]
		user.alternate_transport = transport_keys
		user.city = city
		user.put()

		Electricity(user = user.key, bill = electricity).put()
		Water(user = user.key, bill = water).put()
		Gas(user = user.key, bill = gas).put()

class Cars(Base):
	'''
		Stores the car data from http://www.FuelEconomy.gov
	'''

	car_id = ndb.IntegerProperty(required = True)
	make = ndb.StringProperty(required = True)
	model = ndb.StringProperty(required = True)
	year = ndb.IntegerProperty(required = True)
	emissions_per_km = ndb.FloatProperty(required = True)


	@classmethod
	def save(cls, car_id):
		'''
			Accepts a car ID. If the car doesn't exist,
			fetch the data and save the new car.
		'''

		if not cls.query(cls.car_id == int(car_id)).count() > 0:
			url = "http://fueleconomy.gov/ws/rest/vehicle/%s" %str(car_id)
			xml = urllib2.urlopen(url).read()

			start = xml.find("<make>")+6
			end = xml.find("</make>")
			make = xml[start:end]

			start = xml.find("<model>")+7
			end = xml.find("</model>")
			model = xml[start:end]

			start = xml.find("<year>")+6
			end = xml.find("</year>")
			year = xml[start:end]

			start = xml.find("<co2TailpipeGpm>")+16
			end = xml.find("</co2TailpipeGpm>")
			emissions_per_mile = float(xml[start:end])

			emissions_per_km = emissions_per_mile / 1.6

			return cls(car_id = int(car_id), make = make, model = model, 
				year = int(year), emissions_per_km = emissions_per_km).put()


class AlternateTransport(Base):
	'''
		Stores alternate transport methods.
		Public Transit, Biking and Walking

	'''

	transport_type = ndb.StringProperty(required = True)
	emissions_per_km = ndb.FloatProperty(required = True)


class Distance(Base):
	'''
		Stores distances from when a user starts to 
		move right until the user stops.
	'''

	user = ndb.KeyProperty(kind = Users)
	distance = ndb.FloatProperty(required = True)
	transport_method = ndb.KeyProperty(kind = AlternateTransport)


class Electricity(Base):
	'''
		Stores electricity use information.
	'''

	user = ndb.KeyProperty(kind = Users)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(default = 0)


class Gas(Base):
	'''
		Stores gas use information.
	'''

	user = ndb.KeyProperty(kind = Users)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(default = 0)


class Water(Base):
	'''
		Stores water user information.
	'''

	user = ndb.KeyProperty(kind = Users)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(default = 0)
