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

class TransportMethods(Base):
	method = ndb.StringProperty(required = True)

class Distance(Base):
	'''
		Stores distances from when a user starts to 
		move right until the user stops.
	'''

	user = ndb.KeyProperty(kind = Users)
	distance = ndb.FloatProperty(required = True)
	transport_method = ndb.KeyProperty(kind = TransportMethods)
