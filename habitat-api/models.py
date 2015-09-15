from google.appengine.ext import ndb

class Base(ndb.model):
	'''
		Base model - inherited by all other models.
	'''

	created = ndb.DateTimeProperty(auto_now_add = True)
	updated = ndb.DateTimeProperty(auto_now = True)


class Users(Base):
	'''
		Contains some user information.
	'''


class Cars(Base):
	'''
		Stores the car data from http://www.FuelEconomy.gov
	'''

	car_id = ndb.IntegerProperty(required = True)
	make = ndb.StringProperty(required = True)
	model = ndb.StringProperty(required = True)
	car_type = ndb.StringProperty(required = True)
	emissions_per_km = ndb.FloatProperty(required = True)


class AlternateTransport(Base):
	'''
		Stores alternate transport methods.
		Public Transit, Biking and Walking

	'''

	transport_type = ndb.StringProperty(required = True)
	emissions_per_km = ndb.FloatProperty(required = True)


class TransportMethods(Base):
	'''
		Stores the possible methods of transport.
		Car, Public Transit, Biking and Walking
	'''
	method = ndb.StringProperty(required = True)


class Distance(Base):
	'''
		Stores distances from when a user starts to 
		move right until the user stops.
	'''

	user = ndb.KeyProperty(kind = Users)
	distance = ndb.FloatProperty(required = True)
	transport_method = ndb.KeyProperty(kind = TransportMethods)


class Electricity(Base):
	'''
		Stores electricity use information.
	'''

	user = ndb.KeyProperty(kind = User)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(required = True)


class Gas(Base):
	'''
		Stores gas use information.
	'''

	user = ndb.KeyProperty(kind = User)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(required = True)


class Water(Base):
	'''
		Stores water user information.
	'''

	user = ndb.KeyProperty(kind = User)
	bill = ndb.FloatProperty(required = True)
	cycle_in_days = ndb.IntegerProperty(required = True)
